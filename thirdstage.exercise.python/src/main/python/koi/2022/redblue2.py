
reds = [[1, 2], [2, 5], [3, 5]]
blues = [[2, 7], [7, 11], [3, 6], [10, 3]]

counts = dict() 
for red in reds:
  counts[red[0], red[1]] = 1

for blue in blues:
  counts[blue[0], blue[1]] = -1

print(counts)


x0 = 1     # max x
x1 = 10   # min x
y0 = 2     # max y
y1 = 11    # min y

W = 5
H = 3

sums = [[0] * (y1 - y0 + H + 1) for i in range(x1 - x0 + W + 1)]

for i in range(x0 - W, x1 + 1) :
  for j in range(y0 - H, y1 + 1) :
    
    if i == x0 - W and j == y0 - H:
      for p in range(x0 - W, x0 + 1):
        for q in range(y0 - H, y0 + 1):
          sums[0][0] = sums[0][0] + counts.get((p, q), 0)
      continue
    
    if j == y0 - H:
      sums[i - x0 + W][0] = sums[i - x0 + W - 1][0]
      for q in range(y0 - H , y0 + 1):
        
        sums[i - x0 + W][0] = sums[i - x0 + W][0] + counts.get((i + W, q), 0) - counts.get((i  - 1, q), 0)
      continue

    
    sums[i - x0 + W][j - y0 + H] = sums[i - x0 + W][j - y0 + H - 1]
    for p in range(i, i + W + 1):
      sums[i - x0 + W][j - y0 + H] = sums[i - x0 + W][j - y0 + H] + (counts.get((p, j + H), 0) - counts.get((p, j - 1), 0))

    if(sums[0][0] == 0):
      print('case 2 : ', i - x0 + W, j - y0 + H)

print(sums[0][0])
print(sums)
