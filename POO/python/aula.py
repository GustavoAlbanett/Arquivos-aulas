# def soma(x,y):
#     soma = x + y
#     return soma

# def maior(x,y,z):
#     maior = None
#     vet = [x, y, z]
#     for i in vet:
#         if(maior == None or maior <= i ):
#             maior = i

#     return maior

# def maiorLista(vet):
#     maior = None
#     for i in vet:
#         if(maior == None or maior <= i ):
#             maior = i

#     return maior

# def vetores(vet1, vet2):
#     vet = vet1 + vet2
    
#     aux = 0
#     for i in range(0, len(vet)):
#         for j in range(0, len(vet)-1):
#             if(vet[j] > vet[j+1]):
#                 aux = vet[j]
#                 vet[j] = vet[j+1]
#                 vet[j+1] = aux
#     return vet




# def principal():
#     num1 = 10
#     num2 = 50
#     num3 = 20
#     lista = [2, 10, 33, 70]
#     lista2 = [4, 11, 15, 20, 77]
#     r = vetores(lista, lista2)
#     print(f"resultado = {r}")

# principal( )

# # 8, 2 - 6, 101 - 107,6, 7


x = [2, 10, 33, 70,]
y = [4, 11, 15, 20, 77]
r = []

tam = len(x) +len(y)

for i in range(tam):
    # if(len(x) == 0):
    #     r.append(y[0])
    #     del(y[0])
    if(len(y) != 0 and x[0] < y[0]):
        r.append(x[0])
        del(x[0])
    
    # if(len(y) == 0):
    #     r.append(x[0])
    #     del(x[0])
    if(len(x) != 0 and y[0] < x[0] ):
        r.append(y[0])
        del(y[0])

print(r)