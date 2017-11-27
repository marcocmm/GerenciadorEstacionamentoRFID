Processo de construção 
Controle de acesso com módulo RFID e Software Gerenciador

  Giovani Henrique Bertuzzo				Marco Cezar Moreira
giovani.hbertuzzo@gmail.com 		          marco.cmm@gmail.com

Professor Radames J. Halmeman
Disciplina Computação Física

O sistema

O seguinte material, disponibiliza um passo-a-passo para construção de um sistema que controla frota de veículos (geralmente de empresas) através de dispositivos RFID (cartão, leitor, bottom), e um software gerenciador de todo o sistema. 
RFID (Radio Frequency IDentification ou Identificação por radiofrequência) é uma tecnologia que utiliza sinais de rádio e uma etiqueta (tag) RFID para leitura e gravação de dados.

Funcionamento

Cada funcionário da empresa, recebe um cartão RFID, cada veículo da empresa detém um bottom RFID. Ao utilizar o carro da empresa, o motorista no momento em que estiver saindo do estacionamento com o veículo, selecionará o seu destino, passará seu cartão pessoal, e o bottom do veículo no leitor RFID. Então, o leitor consulta a base de dados do software gestor, e no caso de localizar um motorista e um veículo associado com os RFIDs lidos (previamente cadastrados no sistema), o sistema liberará a cancela para o motorista sair do estacionamento da empresa. Cada vez que um motorista passa pelo leitor, o sistema adiciona um novo registro, com informações do tipo:
Quem foi o Motorista 
Com qual Veículo
Data/Hora do registro
Destino da viagem
	O projeto com todos os códigos (banco, java, arduino) e suas respectivas bibliotecas, podem ser encontrados em:
https://github.com/marcocmm/GerenciadorEstacionamentoRFID

Materiais Necessários

Banco de Dados
Mysql
MySQL Workbench
Software
Java JDK
Netbeans
Bibliotecas
driver JDBC do MySQL
https://dev.mysql.com/downloads/connector/j/5.1.html
biblioteca de comunicação com o MySQL
JPA 2.1
biblioteca de persistência dos dados
RXTXcomm 
biblioteca de comunicação com o arduino
https://github.com/rxtx/rxtx

Circuito Arduino
Módulo RFID RC522
Servo Motor
2 Resistors
2 Leds
14 Fios 
Protoboard para ligações
Software Arduino
IDE Arduino
Arduino Web Editor (opcional, caso não queira instalar a IDE)
https://create.arduino.cc/editor
Biblioteca MFRC522 
https://github.com/miguelbalboa/rfid
Biblioteca Servo
Já presente na IDE do Arduino

Métodos

Base de Dados

Para registrar todas as informações do sistema, é necessário a criação de uma base de dados. Utilizamos o SGBD Mysql com o framework gerenciador de banco de dados MySQL Workbench.
O primeiro passo é criar o MER e o schema da base. 
As tabelas criadas no banco foram:

Motoristas
Campos: ID, Nome, CPF, RFID
Veículos
Campos: ID, Placa, Marca, Modelo, RFID
Destinos
Campos: ID, CEP, Endereço, Número, Nome
Logs
Campos: ID, Data, IdMotorista, IdVeículo, IdDestino

		Abaixo segue uma imagem do diagrama entidade relacionamento completo com seus respectivos  relacionamentos:



		Depois de concluído o processo de criação do diagrama entidade relacionamento(DER), é necessário transformá-lo em código na linguagem SQL, para isso utilize os atalhos CTRL + SHIFT + Z e execute.
Confirme se as tabelas foram criadas realizando uma consulta.

Sistema 

	Para o desenvolvimento do software que gerencia todo o sistema, foi escolhido a linguagem de programação Java, com uso da IDE Netbeans.
	
	De início é necessário sincronizar a base de dados com o software, para isso é necessária a utilização de uma biblioteca/driver, o JDBC do MySQL. Adicione-a em seu projeto.
	Para uma melhor organização do projeto, o código foi dividido em pacotes.

Pacote DAO
Responsável pela comunicação com o base de dados, necessária a criação de uma classe para cada entidade/tabela do banco.

Pacote Controller
Responsável pela criação de métodos auxiliares em cada uma das entidades. Métodos como, Inserir, Alterar, Excluir da base de dados.

Pacote GUI
É o pacote responsável pela interface do sistema, cada classe desse pacote é uma frame existente do sistema. O sistema possui um menu principal, as telas de cadastro de Motorista, Veículos e Destino, uma tela com todos os registros do sistema, uma tela com a possibilidade de filtrar os registros, sendo possível aplicar o filtro, por motorista, por veículo, ou por destino. O sistema também conta com uma tela de lançamento de um novo registro.

Pacote GUI.img
Neste pacote encontram-se todas as imagens utilizadas no sistema.

Pacote Entidades
Aqui ficam as classes do sistema, para cada tabela criada no banco, é necessário uma classe associada. Em cada classe encontra-se o seu construtor, os métodos de acesso (get,set), entre outros métodos auxiliares.

Pacote Main
Contém a classe principal do sistema, que instância a tela do Menu Principal.

Pacote Arduino
Este contém a classe que realiza a comunicação em baixo nível com o hardware do projeto (arduino). Comunicação através de uma porta usb. Para o funcionamento correto dessa classe, é necessário incluir a biblioteca RXTXcomm no projeto.


Abaixo segue um print da árvore do projeto completa.


	
Funcionalidades do Sistema

	No sistema é possível:
Cadastrar um Motorista
Lembrando que cada motorista tem um cartão RFID associado, ao realizar o cadastro é necessário colocar o código RFID correto, para o sistema, ao ler o cartão, conseguir associar qual motorista está realizando a nova viagem.
Cadastrar um Veículo
Lembrando que cada veículo tem um bottom RFID associado, ao realizar o cadastro é necessário colocar o código RFID correto, para o sistema, ao ler o bottom, conseguir associar qual veículo está realizando a nova viagem.
Cadastrar um Destino
O motorista ao passar seu cartão RFID, precisa setar para qual destino é a sua viagem, para isso é necessário cadastrar previamente um novo destino, informando endereço, CEP, número e nome do destino.
Consultar Registros 
Esta funcionalidade lista todos os registros existentes do sistema.
Lançar Novo Registro
Um motorista quando está saindo do estacionamento de sua empresa, passa o seu cartão RFID e bottom do veículo, depois o sistema pede o destino da viagem, então o motorista informa o destino e a cancela é liberada.
O destino tem que estar previamente cadastrado.

Dispositivos de Hardware Arduino

Para o controle de acesso utilizamos o circuito abaixo, lembrando que a alimentação do módulo RFID é feita por meio do pino 3.3V, e o servo motor é alimentado por 5V:

	O componente principal do sistema é o módulo RC522 que utiliza a interface SPI para comunicação com o Arduino por meio dos pinos digitais de 10 à 13, além do pino 9 ligado ao RST do  módulo. Veja na imagem abaixo a disposição dos pinos e a ligação com o Arduino, com os pinos suportados pela biblioteca MFRC522:



No programa utilizamos a biblioteca Servo, já presente na IDE do Arduino, depois adicionamos dois leds para mostrar se o acesso foi liberado (led verde, ligado à porta 5), ou  negado (led vermelho ligado à porta 6). 
Quando o acesso é liberado o servo motor é acionado, movimentando o mesmo em 90 graus, e caso o acesso seja negado, o led vermelho pisca.

Software Arduino

O código completo pode ser encontrado no repositório git, porém comentaremos os principais trechos.	

Conforme falado anteriormente, no código arduino é necessário incluir as bibliotecas Servo, e a biblioteca MFRC522 do módulo RFID.

#include <SPI.h>
#include <MFRC522.h>
#include <Servo.h>

No trecho a seguir é onde é realizado a leitura do cartão

if(!mfrc522.PICC_IsNewCardPresent()) - Aguarda a aproximação do cartão
if(!mfrc522.PICC_ReadCardSerial()) - Seleciona um dos cartões

O leitor, recebe os dados no formato de bytes, portanto é necessário a sua conversão, no trecho abaixo é onde é feita tal conversão.

for (byte i = 0; i < mfrc522.uid.size; i++)
{
	Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
	Serial.print(mfrc522.uid.uidByte[i], HEX);
conteudo.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
conteudo.concat(String(mfrc522.uid.uidByte[i], HEX));
}

Após enviar o código para o dispositivo arduino, e executar o código Java, o sistema já estará apto e funcional.

Referências

https://github.com/marcocmm/GerenciadorEstacionamentoRFID
http://www.arduinoecia.com.br/2014/12/controle-de-acesso-modulo-rfid-rc522.html

