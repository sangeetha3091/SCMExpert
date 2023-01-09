import socket
import json

from random import randint
import time
s = socket.socket()
print("Socket Created")
s.bind(('',12345))
s.listen(3)
print("waiting for connections")
c, addr = s.accept()
data =[{
"Battery_Level":3.52,
 "Device_Id":1156053076,
 "First_Sensor_temperature":12.4 ,
 "Route_From":"Hyderabad",
 "Route_To":"Louisville"
 },
{
"Battery_Level":4.57,
 "Device_Id":1156053077,
 "First_Sensor_temperature":17.8 ,
 "Route_From":"Banglore",
 "Route_To":"Louisville"
},
{
"Battery_Level":8.52,
 "Device_Id":1156053061,
 "First_Sensor_temperature":16.4 ,
 "Route_From":"Asia",
 "Route_To":"Louisville"
 },
{
"Battery_Level":9.50,
 "Device_Id":1156053011,
 "First_Sensor_temperature":10.9 ,
 "Route_From":"Europe",
 "Route_To":"Louisville"
},
{
"Battery_Level":3.52,
 "Device_Id":1156053072,
 "First_Sensor_temperature":19.8 ,
 "Route_From":"Canada",
 "Route_To":"Louisville"
 },
{
"Battery_Level":2.57,
 "Device_Id":1156053091,
 "First_Sensor_temperature":30.3 ,
 "Route_From":"Japan",
 "Route_To":"Louisville"
},
{
"Battery_Level":7.56,
 "Device_Id":1156053176,
 "First_Sensor_temperature":19.1 ,
 "Route_From":"Bangalore",
 "Route_To":"Louisville"
 },
{
"Battery_Level":8.67,
 "Device_Id":1156053040,
 "First_Sensor_temperature":21.4 ,
 "Route_From":"Hyderabad",
 "Route_To":"Louisville"
}]
while True:
    try:
        print("connected with", addr)
        userdata = (json.dumps(data)+"\n").encode('utf-8')
        print(userdata)
        c.send(userdata)
        time.sleep(100)
    except Exception as e:
        print(e)
        c.close()
