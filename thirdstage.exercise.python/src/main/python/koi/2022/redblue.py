
reds = [[1, 2], [2, 5], [3, 5]]
blues = [[2, 5], [7, 20], [3, 12], [10, 27]]

counts = dict() 
for red in reds:
  counts[red[0], red[1]] = 1

for blue in blues:
  counts[blue[0], blue[1]] = -1

xmin : int = 1
xmax : int = 123
ymin : int = 3
ymax : int = 27

W = 5
H = 3

counts2 = dict()

for i in range(xmin - W, xmax + 1) :
  for j in range(ymin - H, ymax + 1) :
    if i == xmin - W and j == ymin - H:
      for p in range(xmin - W, xmin + 1):
        for q in range(ymin - H, ymin + 1):
          counts2[i, j] = counts2.get((i, j), 0) + counts.get((p, q), 0)
      continue
    
    if j == ymin - H:
      counts2[i, j] = counts2[i - 1, j]
      for q in range(j , j + H + 1):
        counts2[i, j] = counts2[i, j] - counts.get((i  - 1, q), 0) + counts.get((i + W, q), 0) 
      continue

    counts2[i, j] = counts2[i, j - 1]
    for p in range(i, i + W + 1):
      counts2[i, j] = counts2[i, j] - counts.get((p, j - 1), 0) + counts.get((p, j + H), 0)










  