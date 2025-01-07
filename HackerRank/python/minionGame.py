def minion_game(string):
    # Büyük/küçük harf duyarlılığı olmaması için stringi büyük harfe çeviriyoruz
    string = string.upper()
    vowels = "AEIOU"  # Sesli harfler
    length = len(string)
    
    # Skorlar
    score_kevin = 0
    score_stuart = 0

    for i in range(length):
        # Eğer sesli bir harfse Kevin'in skoru artar
        if string[i] in vowels:
            score_kevin += length - i
        else:  # Sessiz harfse Stuart'ın skoru artar
            score_stuart += length - i

    # Skorları karşılaştır
    if score_kevin > score_stuart:
        print(f"Kevin {score_kevin}")
    elif score_stuart > score_kevin:
        print(f"Stuart {score_stuart}")
    else:
        print("Draw")
    
print(minion_game("banana"))

# if __name__ == '__main__':
#     s = input()
#     minion_game(s) 
