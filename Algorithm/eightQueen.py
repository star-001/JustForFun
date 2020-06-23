res = [0]*8
def cal8queens(row):
    if row == 8:
        print_queens(res)
        return
    for col in range(8):
        if is_ok(row,col):
            res[row]=col
            cal8queens(row+1)

def is_ok(row,col):
    leftup=col-1
    rightup=col+1
    for i in range(row-1,-1,-1):
        if res[i] == col: return False
        if leftup >=0:
            if res[i]==leftup:
                return False
        if rightup >=0:
            if res[i] == rightup:
                return False
        leftup -= 1
        rightup += 1
    return True
def print_queens(res):
    for row in range(8):
        for col in range(8):
            if res[row] == col:
                print('Q ',end='')
            else:
                print('* ',end='')
        print()
    print()

cal8queens(1)