import bext  # https://pypi.org/project/Bext/
import time  # https://docs.python.org/3/library/time.html

w, h = bext.size()
w = min(20, w)
h = min(15, h)
x = int(w/2)
y = int(h/2)
vx = 1
vy = 1
update_interval = 1  # time interval in seconds

def init() :
  bext.clear()
  bext.goto(0, 0)
  for i in range(0, w) :
    bext.goto(i, 0)
    print('-') if(i > 0 and i < w - 1) else print('+') 
  for i in range(0, w) :
    bext.goto(i, h - 1)
    print('-') if(i > 0 and i < w - 1) else print('+') 
  for j in range(1, h - 1) :
    bext.goto(0, j)
    print('|')
  for j in range(1, h - 1) :
    bext.goto(w - 1, j)
    print('|')  
  bext.goto(x, y)
  print('*')


def update() :
  global x, y, vx, vy
  bext.goto(x, y)
  print(' ')
  x = x + vx
  y = y + vy
  if(x <= 0) :
    x = -x
    vx = -vx
  elif(x >= w - 1) :
    x = 2 * (w -1) - x
    vx = -vx
  if(y <= 0) :
    y = -y
    vy = -vy
  elif(y >= h - 1) :
    y = 2 * (h - 1) - y
    vy = -vy
  bext.goto(x, y)
  print('*')


init()

for i in range(0, 1000) : 
  update()
  time.sleep(update_interval)



