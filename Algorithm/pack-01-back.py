items=[1,5,8,10,9]
max_weigh=-1
cap=4
def pack(i,w):
    global max_weigh
    if w > max_weigh:
        max_weigh=w
    if i==len(items): return
    pack(i+1,w)
    if w+items[i] <= cap:
        pack(i+1,w+items[i])
pack(0,0)
print(max_weigh)
