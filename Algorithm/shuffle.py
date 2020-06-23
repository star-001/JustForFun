from random import randint

def my_shuffle(a):
    res = a
    end = len(res)-1
    for i in range(len(res)):
        k = randint(0,end)
        res[k],res[end]=res[end],res[k]
        end -=1
    return res

print(my_shuffle([1,2,3,4,5]))