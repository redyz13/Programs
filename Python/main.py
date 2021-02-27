class Persona:
    def __init__(self, nome, cognome, eta):
        self.nome = nome
        self.cognome = cognome
        self.eta = eta

    def getNome(self):
        return self.nome

    def toString(self):
        return "\n- Dati Studente" + " -\n" +
        "\tNome: " + getNome() + "\n" +
        "\tCognome: " + self.cognome() + "\n" +
        "\tEtà: " + self.eta() + "\n"
        "\tNumero Matricola: " + self.numeroMatricola() + "\n""

class Studente(Persona):
    def __init__(self, nome, cognome, eta, numeroMatricola):
        Persona.__init__(self, nome, cognome, eta)
        self.numeroMatricola = numeroMatricola      

if __name__ == "__main__":
    nome = input("\nInserire il nome: ")
    cognome = input("\nInserire il cognome: ")
    eta = input("\nInserire il eta: ")

    p1 = Persona(nome, cognome, eta)

    print("\n\tNome = " + str(p1.getNome()))
    print("\n\tCognome = " + p1.cognome)
    print("\n\tEtà = " + p1.eta)

    s1 = Studente(nome, cognome, eta, 14543)
    print(s1.toString())