from random import randint
from typing import Callable,List
def test_splitredenvelope(total:int,pieces:int,split_redenvelope:Callable)->None:
    res = split_redenvelope(total,pieces)
    assert len(res)==pieces
    assert sum(res)==total * 100
    assert max(res)<90*total

def split_redenvelope(total:int,pieces:int)->List:
    res = []
    if total > 200:
        raise ValueError("max money is 200")
    if total <= 0:
        raise ValueError("minum money is 0.01")
    if pieces < 0:
        raise ValueError("minum pieces is 1")
    if pieces > 100:
        raise ValueError("maxium pieces is 100")
    if total/pieces < 0.01:
        raise ValueError("per envelope money should bigger than 0.01")
    FACTOR = 100
    total = int(total * FACTOR)
    upon_edge= int(total*0.9)
    point_one_total = int(total*0.1)
    
    while total != 0 and pieces > 0:
        if pieces == 1:
            parted_envelope = total
        elif total == pieces:
            parted_envelope =1
        elif pieces == 2 and total>upon_edge:
            parted_envelope = randint(point_one_total,upon_edge)
        else:
            if total-pieces > upon_edge:
                parted_envelope = randint(1,upon_edge)
            else:
                parted_envelope = randint(1,total-pieces)
        
        total -= parted_envelope
        pieces -= 1
        res.append(parted_envelope)
    return res
