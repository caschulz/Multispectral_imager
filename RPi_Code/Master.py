# Echo client program 
import socket 
import datetime 
import time 
HOST = '169.254.1.2'    
HOST1 = '169.254.1.3' 
HOST2 = '169.254.1.4' 
HOST3 = '169.254.1.5' 
 
PORT = 50009              # The same port as used by the server 
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
s1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
s2 = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
s3 = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
s.connect((HOST, PORT)) 
s1.connect((HOST1, PORT)) 
s2.connect((HOST2, PORT)) 
s3.connect((HOST3, PORT)) 
time.sleep(2) 
s.sendall("1") 
s1.sendall("1") 
s2.sendall("1") 
s3.sendall("1") 
time.sleep(1) 
s.sendall('close connection') 
s.close 
s1.sendall('close connection') 
s1.close 
s2.sendall('close connection') 
s2.close 
s3.sendall('close connection') 
s3.close 
print("/var/www/") 


