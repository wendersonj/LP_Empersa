# LP_Empersa

Cliente tem dados e pode solicitar um Serviço
Uma agenda apresenta um calendario e uma data pode ter um compromisso com quem 

Uma empresa possui prestadores de serviços e uma agenda. O serviço contém a descrição do que vai ser feito. A agenda disponibiliza datas. Cada prestador de serviços da empresa pode oferecer determinado serviço em uma data para um cliente, apenas se tiver disponibilidade na agenda. 

Empresa:
nome
cnpj
lista prestadores
agenda com agenda dos prestadores
clientes

Prestador
nome
id
agenda

Cliente
nome
cpf

Serviço
Nome
descricao

Agenda
Calendario
Lista compromissos (lista de datas)

agendarServiço(Cliente, Prestador, Servico, Agenda em que vai ser colocada, Data do inicio "-" obs: cada serviço gerencia os dias para realizar o serviço))

