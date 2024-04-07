
# KOI, 2022, 2nd, Elementary 2
# https://koi.or.kr/assets/koi/2022/2/problems/changing-cards.pdf

MAX_VAL = 5000
MIN_VAL = -5000

def find(values):
  n = len(values)
  slopes = []
  max_s = 1.0
  min_s = -1.0 

  for i in range(0, n): 
    if(i == 0): max_s = (MAX_VAL - values[i])/n
    elif(i == n - 1): max_s = (values[i] - MIN_VAL)/n
    else:
      max_s = max((MAX_VAL - values[i])/(n - i), (values[i] - MIN_VAL)/i) 

    slopes[i] = [];
    for j in range(0, n) : 
      if(j == i) : continue
      s = (values[j] - values[i])/(j - i)
      
