package com.lab3.resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
/**
 *
 */
public class City {

    public static void main(String[] args) {

        try {
            String xmldata = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\r\n<SOAP-ENV:Body>\r\n<ns3591:NDFDgen xmlns:ns3591=\"uri:DWMLgen\">\r\n<latitude xsi:type=\"xsd:string\">38.99</latitude>\r\n<longitude xsi:type=\"xsd:string\">-77.01</longitude>\r\n<product xsi:type=\"xsd:string\">time-series</product>\r\n<startTime xsi:type=\"xsd:string\">2004-01-01T00:00:00</startTime>\r\n<endTime xsi:type=\"xsd:string\">2017-02-15T00:00:00</endTime>\r\n<Unit xsi:type=\"xsd:string\">e</Unit>\r\n<weatherParameters>\r\n<maxt xsi:type=\"xsd:boolean\">1</maxt>\r\n<mint xsi:type=\"xsd:boolean\">1</mint>\r\n<temp xsi:type=\"xsd:boolean\">0</temp>\r\n<td xsi:type=\"xsd:boolean\">0</td>\r\n<pop12 xsi:type=\"xsd:boolean\">0</pop12>\r\n<qpf xsi:type=\"xsd:boolean\">0</qpf>\r\n<sky xsi:type=\"xsd:boolean\">0</sky>\r\n<snow xsi:type=\"xsd:boolean\">0</snow>\r\n<wspd xsi:type=\"xsd:boolean\">0</wspd>\r\n<wdir xsi:type=\"xsd:boolean\">0</wdir>\r\n<wx xsi:type=\"xsd:boolean\">0</wx>\r\n<waveh xsi:type=\"xsd:boolean\">0</waveh>\r\n<icons xsi:type=\"xsd:boolean\">0</icons>\r\n<critfireo xsi:type=\"xsd:boolean\">0</critfireo>\r\n<dryfireo xsi:type=\"xsd:boolean\">0</dryfireo>\r\n<rhm xsi:type=\"xsd:boolean\">0</rhm>\r\n<apt xsi:type=\"xsd:boolean\">0</apt>\r\n<tcwspdabv34i xsi:type=\"xsd:boolean\">0</tcwspdabv34i>\r\n<tcwspdabv50i xsi:type=\"xsd:boolean\">0</tcwspdabv50i>\r\n<tcwspdabv64i xsi:type=\"xsd:boolean\">0</tcwspdabv64i>\r\n<tcwspdabv34c xsi:type=\"xsd:boolean\">0</tcwspdabv34c>\r\n<tcwspdabv50c xsi:type=\"xsd:boolean\">0</tcwspdabv50c>\r\n<tcwspdabv64c xsi:type=\"xsd:boolean\">0</tcwspdabv64c>\r\n<conhazo xsi:type=\"xsd:boolean\">0</conhazo>\r\n<ptornado xsi:type=\"xsd:boolean\">0</ptornado>\r\n<phail xsi:type=\"xsd:boolean\">0</phail>\r\n<ptstmwinds xsi:type=\"xsd:boolean\">0</ptstmwinds>\r\n<pxtornado xsi:type=\"xsd:boolean\">0</pxtornado>\r\n<pxhail xsi:type=\"xsd:boolean\">0</pxhail>\r\n<pxtstmwinds xsi:type=\"xsd:boolean\">0</pxtstmwinds>\r\n<ptotsvrtstm xsi:type=\"xsd:boolean\">0</ptotsvrtstm>\r\n<ptotxsvrtstm xsi:type=\"xsd:boolean\">0</ptotxsvrtstm>\r\n<tmpabv14d xsi:type=\"xsd:boolean\">0</tmpabv14d>\r\n<tmpblw14d xsi:type=\"xsd:boolean\">0</tmpblw14d>\r\n<tmpabv30d xsi:type=\"xsd:boolean\">0</tmpabv30d>\r\n<tmpblw30d xsi:type=\"xsd:boolean\">0</tmpblw30d>\r\n<tmpabv90d xsi:type=\"xsd:boolean\">0</tmpabv90d>\r\n<tmpblw90d xsi:type=\"xsd:boolean\">0</tmpblw90d>\r\n<prcpabv14d xsi:type=\"xsd:boolean\">0</prcpabv14d>\r\n<prcpblw14d xsi:type=\"xsd:boolean\">0</prcpblw14d>\r\n<prcpabv30d xsi:type=\"xsd:boolean\">0</prcpabv30d>\r\n<prcpblw30d xsi:type=\"xsd:boolean\">0</prcpblw30d>\r\n<prcpabv90d xsi:type=\"xsd:boolean\">0</prcpabv90d>\r\n<prcpblw90d xsi:type=\"xsd:boolean\">0</prcpblw90d>\r\n<precipa_r xsi:type=\"xsd:boolean\">0</precipa_r>\r\n<sky_r xsi:type=\"xsd:boolean\">0</sky_r>\r\n<td_r xsi:type=\"xsd:boolean\">0</td_r>\r\n<temp_r xsi:type=\"xsd:boolean\">0</temp_r>\r\n<wdir_r xsi:type=\"xsd:boolean\">0</wdir_r>\r\n<wspd_r xsi:type=\"xsd:boolean\">0</wspd_r>\r\n<wgust xsi:type=\"xsd:boolean\">0</wgust>\r\n<iceaccum xsi:type=\"xsd:boolean\">0</iceaccum>\r\n<maxrh xsi:type=\"xsd:boolean\">0</maxrh>\r\n<minrh xsi:type=\"xsd:boolean\">0</minrh>\r\n</weatherParameters>\r\n</ns3591:NDFDgen>\r\n</SOAP-ENV:Body>\r\n</SOAP-ENV:Envelope>";
            //Create socket
            String hostname = "graphical.weather.gov";
            int port = 443;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket sock = new Socket(addr, port);
            System.out.println("Socket connected");
            //Send header
            String path = "/xml/SOAP_server/ndfdXMLserver.php#NDFDgen";
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"));
            wr.write("GET "+ path + " HTTP/1.1\r\n");
            wr.write("Host: graphical.weather.gov:443\r\n");
            wr.write("Content-Length:"+ xmldata.length() + "\r\n");
            wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
            wr.write("SOAPAction: \"http://graphical.weather.gov/xml/DWMLgen/wsdl/ndfdXML.wsdl#NDFDgen\"");
            wr.write("\r\n");            //Send data
            wr.write(xmldata);
            wr.flush();
            System.out.println("Request sent");
            // Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}