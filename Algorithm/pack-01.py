import sys
maxW = 0

def pack(i,cw,items,n,w):
    global maxW
    if cw==w or i==n:
        if cw > maxW:
            maxW = cw
        return
    pack(i+1,cw,items,n,w)
    if (cw+items[i] <= w):
        pack(i+1,cw+items[i],items,n,w)


a=[3,4,7]

pack(0,0,a,3,8)
print(maxW)