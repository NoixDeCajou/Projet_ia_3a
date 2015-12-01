#include <Ethernet.h>
 
int loopflag;// MAC address is on a sticker on the back of the Galileo
 
byte mac[] = { 0x98, 0x4F, 0xEE, 0x05, 0x32, 0x87 }; // Gali 11
IPAddress my_server(192,168,1,9); //needs to be modified to ip address in ifconfig
EthernetClient client;
 
void setup()
{
    // restart network interface on the Galileo
    system("ifdown eth0");
    system("ifup eth0");
     
    // 2 second delay just so that we can catch debug messages on serial monitor
    delay(2000);
     
    Serial.begin(9600);
    while (!Serial);
     
    if (Ethernet.begin(mac) == 1) Serial.println("Ethernet.begin() succeeded");
    else Serial.println("Ethernet.begin() failed");
    delay(1000);
 
    Serial.print("The Galileo IP address is: "); //get IP address from DHCP
    Serial.println(Ethernet.localIP());
    delay(1000);
 
    Serial.println("connecting...");
    if (client.connect(my_server, 9741) == true)
    {
        Serial.println("connected to server on port 20001");
    }
    else
    {
        Serial.println("failed to connect to server on port 20001");
    }
}
 
void loop()
{
    Serial.print("Start of loop...");
 
     
    if (client.connected() == true)
    {
        Serial.println("still connected for data");
    }
    else
    {
        //Serial.println("reconnecting");
        if (client.connect(my_server, 9741) == true)
        {
            Serial.println("re-connected for data");
        }
    }
     
    delay(10);
    char sendBuf[11]; //scaling code could be added in after this line
    String sendStr = String(19);
    sendStr.concat(",");
    sendStr.concat(20);
    sendStr.toCharArray(sendBuf,11);
    client.println(sendBuf);
    Serial.println(sendBuf);
    char c = client.read(); //expect an ack character from server
}
