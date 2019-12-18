from random import randint
def test_splitredenvelope(total,pieces,split_redenvelope):
    res = split_redenvelope(total,pieces)
    assert len(res)==pieces
    assert sum(res)==total * 100
    assert max(res)<90*total

def split_redenvelope(total,pieces):
    res = []
    if total > 200:
        raise ValueError("too big")
    if total <=0:
        raise ValueError("too small")
    FACTOR=100
    total = int(total * FACTOR)
    upon_edge= int(total*0.9)
    point_one_total = int(total*0.1)
    
    while total != 0 and pieces > 0:
        if pieces == 1:
            parted_envelope = total
        elif pieces == 2 and total>upon_edge:
            parted_envelope = randint(point_one_total,upon_edge)
        else:
            parted_envelope = randint(100,total//pieces)
        
        total -= parted_envelope
        pieces -= 1
        res.append(parted_envelope)
    return res
