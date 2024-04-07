
# Alphabet Rectangle 1 
# https://jungol.co.kr/problem/1307

alphas = ('A', 'B', 'C', 'D', 'E',
          'F', 'G', 'H', 'I', 'J',
          'K', 'L', 'M', 'N', 'O',
          'P', 'Q', 'R', 'S', 'T',
          'U', 'V', 'W', 'X', 'Y', 
          'Z')

def get_alpha(m) :
  return alphas[m%26]

def draw(n: int) :
  for i in range(n) :
    line: str = ""
    for j in range(n) :
      line = line + get_alpha(n * i + j) + ' '
    print(line)


def draw2(n: int) :
  """ mirror against the line : `x + y = n - 1` """

  for i in range(n) :
    line: str = ""
    for j in range(n) :
      line = line + get_alpha(n * (n - 1 - j) + (n - 1 - i)) + ' '
    print(line)


def draw3(n: int) :
  """ mirror against the line : `x = y` """

  for i in range(n) :
    line: str = ""
    for j in range(n) :
      line = line + get_alpha(n * j + i) + ' '
    print(line)

draw(7)
print('')
draw2(7)
print('')
draw3(7)
