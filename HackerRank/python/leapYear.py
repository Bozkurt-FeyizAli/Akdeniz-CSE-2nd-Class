def is_leap(year):
    if(year%400==0):
        return True
    if(year%4==0):
        if(year%100==0):
            return False
        else: return True
    else: return False

    
    # Write your logic here
    
    return leap

year = int(input())
print(is_leap(year))