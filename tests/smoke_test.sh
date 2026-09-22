#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TMP="$(mktemp -d)"
trap 'rm -rf "$TMP"' EXIT
javac -d "$TMP/seafood" "$ROOT/projects/seafood/Main.java" "$ROOT/projects/seafood/SeafoodItem.java"
printf 'Salmon\n12.50\n2\nShrimp\n9.99\n1\nCod\n7.25\n3\n' | java -cp "$TMP/seafood" Main > "$TMP/seafood-output.txt"
grep -q 'Salmon' "$TMP/seafood-output.txt"
javac -d "$TMP/password" "$ROOT/projects/password/Assessment04.java"
printf 'ValidPass9!\n' | java -cp "$TMP/password" Assessment04 > "$TMP/password-output.txt"
grep -qi 'password' "$TMP/password-output.txt"
javac -d "$TMP/stock" "$ROOT/projects/stock/Stock.java" "$ROOT/projects/stock/StockDemo.java"
java -cp "$TMP/stock" StockDemo > "$TMP/stock-output.txt"
grep -q '1.37%' "$TMP/stock-output.txt"
node --check "$ROOT/script.js"
python3 - "$ROOT" <<'PYTEST'
from pathlib import Path
from html.parser import HTMLParser
import sys
root=Path(sys.argv[1])
class LinkParser(HTMLParser):
 def __init__(self): super().__init__(); self.links=[]
 def handle_starttag(self, tag, attrs):
  for k,v in attrs:
   if k in ('href','src') and v and not v.startswith(('http:', 'https:', 'mailto:', '#', 'data:')): self.links.append(v.split('#')[0])
for page in [root/'index.html',root/'projects/database-project.html']:
 p=LinkParser(); p.feed(page.read_text(encoding='utf-8'))
 for link in p.links:
  assert (page.parent/link).exists(), f'Missing link from {page}: {link}'
print('Website links: PASS')
PYTEST
echo 'Java compilation and smoke tests: PASS'
echo 'JavaScript syntax: PASS'
