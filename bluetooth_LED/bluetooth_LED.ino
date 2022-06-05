
/*

//https://forum.arduino.cc/t/strcmp-function-doesnt-work/568646

char input[15];
const int led = 13;

void setup() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
  Serial.println("Write 'switch on' or 'turn on' to HIGH");
}

void loop() {
  int i=0;
  
  if (Serial.available()>0){
    while (Serial.available()>0) {
      
      delay(2);  //delay to allow byte to arrive in input buffer
      char c = Serial.read();
      
      input[i] = c;
      i++;
    }
    Check (input);
  }
}

void Check(char command[]){
  int i=0;
  
  if ((strcmp(command, "switch on") == 10) || (strcmp(command, "turn on") == 10))
    digitalWrite(led, HIGH);
  
  else
    digitalWrite(led, LOW);
}

*/



char inputByte;

void setup() {
 Serial.begin(9600);
 pinMode(13,OUTPUT);
 digitalWrite(13,HIGH);
}

void loop() {
  while(Serial.available()>0){
    
      inputByte = Serial.read();
      Serial.println(inputByte);
//      Serial.write(inputByte);
      
      if (inputByte=='1'){
      digitalWrite(13,HIGH);
    }
    
    else if (inputByte=='0'){
      digitalWrite(13,LOW);
      } 
    }
}
