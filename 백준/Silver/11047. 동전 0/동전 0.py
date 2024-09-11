import sys

n, k = map(int, input().split())
coin = [ int(sys.stdin.readline().rstrip()) for _ in range(n) ]
coin = sorted(coin, reverse=True)

count = 0
for i in range(n):
    if k // coin[i] != 0:
        count += k // coin[i]
        k %= coin[i]

print(count)