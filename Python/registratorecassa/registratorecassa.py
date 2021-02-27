costofinale = 0
pagamento = False

while True:
	print('''
	Vuoi aggiungere un articolo alla cassa?\n
	1. Si (y)
	2. No (n)
	''')
	risposta = input('Riposta = ')

	if(risposta == 'y'):
		costoarticolo = float(input('\nPrezzo articolo = EUR '))
		numeroarticoli = float(input('Quantità articolo: '))
		scontoarticolo = float(input('Sconto del prodotto = % '))

		costoarticolo = costoarticolo * numeroarticoli
		costoscontato = (costoarticolo * scontoarticolo) / 100
		costoscontato = costoarticolo - costoscontato
		costofinale = costofinale + costoscontato
	elif(risposta == 'n'):
		break

print('\nLista articoli terminata!')
print('Totale spesa = ' + str(costofinale) + '\n')

if(costofinale > 0):
	pagamento = float(input('Effettuare il pagamento: EUR '))
if(pagamento > costofinale):
	resto = pagamento - costofinale
	print('Il suo resto è di EUR ' + str(resto))