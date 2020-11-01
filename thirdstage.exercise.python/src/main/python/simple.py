
import time
from time import sleep

for i in range(1, 11):
    print(i)
    
    
count = 0    
for i in range(10, 21):
    
    if i%3 == 0:
        print(f"{i} 은 3의 배수이다.")
        count = count + 1
    else:
        print(f"{i} 은 3의 배수가 아니다.")

print(f"10에서 20 사이의 3의 배수는 {count}개이다.")        

secs = 5;


print(f"현재 시각 : {time.strftime('%Y-%m-%d %H:%M:%S')}.")

print(f"{secs}초 동안 쉬었다가 종료라고 출력할 것이다.")
sleep(secs)
print(f"{secs}초 sleep 종료")

