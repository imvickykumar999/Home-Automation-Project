
# https://problemsolvingwithpython.com/11-Python-and-External-Hardware/11.02-Bytes-and-Unicode-Strings/

# pip3 install --upgrade pyserial

import serial, keyboard, time                   # add Serial library for Serial communication

Arduino_Serial = serial.Serial('com8',9600)     # Create Serial port object called arduinoSerialData
print (Arduino_Serial.readline())               # read the serial data and print it as line

while True:                                     # Send 1 or 0 automatically
    data = '1'
    Arduino_Serial.write(data.encode())
    print ("Data sent ", data)                  # prints the data
    time.sleep(1)

    data = b'0'
    Arduino_Serial.write(data)
    print ("Data sent ", data.decode())         # prints the data
    time.sleep(1)
    
    if keyboard.is_pressed('q'):                # if key 'q' is pressed 
        break                                   # finishing the loop