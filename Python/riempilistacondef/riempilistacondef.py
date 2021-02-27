def compilelist(list,index):
	for i in range(0,index):
		array.insert(i,int(input('Inserire il ' + str(i+1) + ' numero: ')))


array = []
index = int(input('Quanti elementi vuoi inserire nella lista?: '))
compilelist(array,index)

for i in range(0,index):
	print('\nNumero della cella ' + str(i) + ' = ' + str(array[i]))