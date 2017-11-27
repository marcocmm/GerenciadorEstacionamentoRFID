
// Programa : RFID - Controle de acesso / cancela
// Autor : Arduino e Cia

#include <SPI.h>
#include <MFRC522.h>
#include <Servo.h> 
 
Servo microservo9g;

#define SS_PIN 10
#define RST_PIN 9
// Definicoes pino modulo RC522
MFRC522 mfrc522(SS_PIN, RST_PIN); 

// Leds indicadores acesso liberado ou negado
int led_liberado = 5;
int led_negado = 6;
String incomingByte = "";
char st[20];

void setup() 
{
  pinMode(led_liberado, OUTPUT);
  pinMode(led_negado, OUTPUT);
  // Define que o servo esta ligado a porta digital 3
  microservo9g.attach(3);
  // Move o servo para a posicao inicial (cancela fechada)
  microservo9g.write(90);
  // Inicia a serial
  Serial.begin(9600);
  // Inicia  SPI bus
  SPI.begin();
  // Inicia MFRC522
  mfrc522.PCD_Init();
  
}

void loop() 
{

  if (Serial.available() > 0) {
    
    // read the incoming byte:
    incomingByte = Serial.read();
    Serial.println(incomingByte);
    if(incomingByte == "48"){
      digitalWrite(led_negado, HIGH);
      delay(200);
      digitalWrite(led_negado, LOW);
    }else if(incomingByte == "49"){
      microservo9g.write(-90);
      digitalWrite(led_liberado, HIGH);
      delay(3000);
      microservo9g.write(90);
      digitalWrite(led_liberado, LOW);
    }
  }
  // Aguarda a aproximacao do cartao
  if ( ! mfrc522.PICC_IsNewCardPresent()) 
  {
    return;
  }
  // Seleciona um dos cartoes
  if ( ! mfrc522.PICC_ReadCardSerial()) 
  {
    return;
  }
  // Mostra UID na serial
  String conteudo= "";
  byte letra;
  for (byte i = 0; i < mfrc522.uid.size; i++) 
  {
     Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
     Serial.print(mfrc522.uid.uidByte[i], HEX);
     conteudo.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
     conteudo.concat(String(mfrc522.uid.uidByte[i], HEX));
  }
  Serial.println();
  
}
