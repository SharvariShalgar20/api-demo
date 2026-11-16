# exp 1

Step 2 – Open two terminals
You need two separate terminal windows.








urbantecno.com


In BOTH terminals, navigate to your Experiment 1 folder:
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 1"


This path comes from Antigravity's report. If your folder is somewhere else, use its actual location.
Step 3 – Compile the Java files
In Terminal 1:
javac EchoServer.java EchoClient.java


Expected result: No error messages. The .class files will be generated or updated.
Step 4 – Start the server
In Terminal 1:
java EchoServer


Expected output:
Echo Server started...
Waiting for clients...


Important: Keep this terminal running. The server waits for incoming connections.
Step 5 – Start the client
In Terminal 2:
java EchoClient


Expected output:
Connected to Echo Server.
Enter message:


Now type:
Hello


Expected response:
Echo from Server: Hello


Try another message:
How are you?


Expected response:
Echo from Server: How are you?


Step 6 – Disconnect
Type:
Exit


The client disconnects, and the server prints something similar to:
Client 1: Exit
Client 1 disconnected.


Step 7 – Test multiple clients
Keep Terminal 1 running.

Open Terminal 3, navigate to the same folder, and execute:
java EchoClient

---


# Exp 2

Step 1 – Open the Experiment 2 folder
In both terminals:
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 2"


Step 2 – Compile all Java files
In Terminal 1:
javac *.java


This compiles all Java files in the current directory.
Step 3 – Start the RMI server
In Terminal 1:
java AddServer


The server should start its RMI registry and register the addition object.

Keep this terminal open.
Step 4 – Run the client
In Terminal 2:
java AddClient


The client should connect to the server.

Enter two numbers when prompted.

For example:
Enter first number: 10
Enter second number: 20


Expected result:
Result: 30.0


The exact prompts and output formatting depend on your actual AddClient.java.
Step 5 – Verify the RMI registry
Open another terminal and run:
netstat -ano | findstr :1099


Look for a LISTENING entry.

---

# Exp 3 - 3 terminals -

cd "C:\\Users\\DELL\\Downloads\\DCS\\DCS\\Exp 3\\src"



SET CP=.;..\\lib\\jacorb-3.9.jar;..\\lib\\jacorb-omgapi-3.9.jar;..\\lib\\jacorb-services-3.9.jar;..\\lib\\idl.jar;..\\lib\\antlr-2.7.2.jar;..\\lib\\slf4j-api-1.7.14.jar;..\\lib\\slf4j-jdk14-1.7.14.jar;..\\lib\\picocontainer-1.2.jar;..\\lib\\wrapper-3.1.0.jar



## 1st terminal-

Start naming service



java -cp "%CP%" org.jacorb.naming.NameServer -DOAPort=2809





## 2nd terminal

HelloServer



java -cp "%CP%" HelloServer -ORBInitRef NameService=corbaloc::localhost:2809/NameService





## 3rd terminal

HelloClient



java -cp "%CP%" HelloClient -ORBInitRef NameService=corbaloc::localhost:2809/NameService



check -
netstat -ano | findstr :2809

---

# Exp 4

Open PowerShell and execute:
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 4"


Compile:
javac BerkeleyAlgorithm.java


Run:
java BerkeleyAlgorithm


Enter the following sample input:
10:00:00
2
10:00:30
09:59:40

---

# Exp 5

Open one PowerShell terminal.

Step 1 — Navigate
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 5"


Step 2 — Compile both programs
javac BullyAlgorithm.java RingAlgorithm.java


Step 3 — Run Bully Algorithm
java BullyAlgorithm


Enter:
4
10
20
50
40
1


Expected winner: PID 40.

Step 4 — Run Ring Algorithm
java RingAlgorithm


Enter:
5
10
20
30
40
50
1


Expected winner: PID 40.

---

# Exp 6 

Open PowerShell and run:

Step 1 — Navigate to the folder
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 6"


Step 2 — Compile
javac WordCountSimulator.java


Step 3 — Execute
java WordCountSimulator

---

# EXp 7

Open PowerShell.

Step 1 — Navigate to the folder
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 7"


Step 2 — Compile
javac termination_detection.java


Step 3 — Run
java termination_detection


Important: The class name is lowercase with an underscore. Java is case-sensitive.

Step 4 — Enter sample input
3
1
2
2


This means:
Input	Meaning
3	Total processes
1	Sender process
2	Receiver process
2	Process receiving the message

Expected final output:
All processes are becoming passive...

Process 1: PASSIVE
Process 2: PASSIVE
Process 3: PASSIVE
Messages in transit: 0

SYSTEM HAS TERMINATED

---

# Exp 8

You need two PowerShell terminals.
Terminal 1 — Start the server
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 8"

javac NameServer.java NameClient.java

java NameServer


Expected output:
Name Server started...
Waiting for client connection...


Keep this terminal running

Terminal 2 — Start the client
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 8"

java NameClient


Enter:
google


Expected response:
Server response: 142.250.195.14

---

# Exp 9

That's fine. Let's install a clean copy in `C:\apache-activemq` so the location is easy to remember.

Recommended version: ActiveMQ Classic 6.3.3

Your Experiment 9 uses `jakarta.jms.*`, so ActiveMQ 6.x is appropriate. Version 6.3.3 supports Jakarta Messaging and Java 17, 21 and 25.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://activemq.apache.org\&sz=32)

activemq.apache.org+1



## **Step 1 — Download ActiveMQ**

Open the official Apache download page:

[Apache ActiveMQ 6.3.3 — Official download](https://activemq.apache.org/components/classic/download/classic-06-03-03?utm_source=chatgpt.com)

Download the Windows binary:

`apache-activemq-6.3.3-bin.zip`

## **Step 2 — Extract the ZIP**

1. Open your Downloads folder.
2. Right-click the ZIP file.
3. Select **Extract All**.
4. Extract it to `C:\`.
5. Rename the extracted folder to `apache-activemq`.

Your directory should look like this:

```
C:\apache-activemq\
    bin\
        activemq.bat
    conf\
    lib\
    webapps\
```

## **Step 3 — Verify Java**

Open PowerShell:

```
java -version
```

ActiveMQ 6.3.3 requires Java 17 or newer.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://activemq.apache.org\&sz=32)

activemq.apache.org



## **Step 4 — Start ActiveMQ**

```
cd C:\apache-activemq

.\bin\activemq.bat console
```

Keep this terminal open.

## **Step 5 — Verify the broker**

Open another PowerShell terminal:

```
netstat -ano | findstr :61616
```

If you see `LISTENING`, the broker is accepting connections.

**Your next task**

Complete Steps 1–4 and tell me what appears in the ActiveMQ terminal.

Do not compile the Java files yet. We first need to verify the broker starts successfully.

After that, I'll help configure the JMS JAR dependencies and run all three Java programs.

# **Experiment 9 — JMS Publish-Subscribe using Apache ActiveMQ**

Follow these steps in order. You need **4 PowerShell terminals**.

## **Step 1. Start ActiveMQ Broker**

Open Terminal 1:

```
cd "C:\apache-activemq-6.3.3\bin"
.\activemq.bat start
```

Wait for the broker to start.

## **Step 2. Verify ActiveMQ**

Open Terminal 2:

```
netstat -ano | findstr :61616
```

Check that port `61616` shows `LISTENING`.

## **Step 3. Compile Java programs**

Open Terminal 3:

```
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 9"

$lib = "C:\apache-activemq-6.3.3\lib"
$jars = (Get-ChildItem $lib -Filter "*.jar" -Recurse |
    ForEach-Object { $_.FullName }) -join ";"

$cp = ".;C:\apache-activemq-6.3.3\activemq-all-6.3.3.jar;$jars"

javac -cp "$cp" Publisher.java Subscriber1.java Subscriber2.java
```

Expected: No compilation errors.

## **Step 4. Start Subscriber 1**

In Terminal 3:

```
java -cp "$cp" Subscriber1
```

Expected:

```
Subscriber 1 is waiting for messages...
```

## **Step 5. Start Subscriber 2**

Open Terminal 4:

```
cd "C:\Users\Admin\Desktop\practicals\DCS\DCS\Exp 9"

$lib = "C:\apache-activemq-6.3.3\lib"
$jars = (Get-ChildItem $lib -Filter "*.jar" -Recurse |
    ForEach-Object { $_.FullName }) -join ";"

$cp = ".;C:\apache-activemq-6.3.3\activemq-all-6.3.3.jar;$jars"

java -cp "$cp" Subscriber2
```

Expected:

```
Subscriber 2 is waiting for messages...
```

## **Step 6. Run Publisher**

Run this in Terminal 3 or open another terminal and recreate `$cp`:

```
java -cp "$cp" Publisher
```

Expected publisher output:

```
Publishing message...
Message published successfully.
```

Expected Subscriber 1 output:

```
Subscriber 1 received: Hello from Publisher!
```

Expected Subscriber 2 output:

```
Subscriber 2 received: Hello from Publisher!
```
