# https://pypi.org/project/Bext/
import bext

bext.clear()
width, height = bext.size()
height = min(10, height)


for i in range(0, width) :
  bext.goto(i, 0)
  print('-')

for j in range(1, height -1 ) :
  bext.goto(0, j)
  print('|')
  bext.goto(width -1 , j)
  print('|')

for i in range(0, width) :
  bext.goto(i, height - 1)
  print('-')



