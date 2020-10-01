package com.es.doctorManagment.managment.utilities;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestClient {

    public String getRequest(String url , String username , String password)
    {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials(username, password);
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();

            HttpGet request = new HttpGet(url);

            //TODO: Change sysOuts to loggers

            System.out.println("Get request : " + url);
            HttpResponse response = client.execute(request);
            System.out.println("response code : " + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String entity = "";
            String line = rd.readLine();
            while (line != null) {
                entity += line ;
                line = rd.readLine();
            }
            return entity;

        }
        catch(IOException e)
        {
            return "error happened";
        }
    }

    public String postRequest(String url , String username , String password , Object object) {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials(username, password);
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();            HttpPost post = new HttpPost(url);
            ObjectMapper mapper = new ObjectMapper();
            StringEntity input = new StringEntity(mapper.writeValueAsString(object) , ContentType.APPLICATION_JSON);
            post.setEntity(input);

            System.out.println("Post request : " + url);
            HttpResponse response = client.execute(post);
            System.out.println("response code : " + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String entity = "";
            String line = rd.readLine();
            while (line != null) {
                entity += line ;
                line = rd.readLine();
            }
            return entity;

        }
        catch(IOException e)
            {
                return "";
            }
        }

    public String putRequest(String url , String username , String password , Object object) {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials(username, password);
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();
            HttpPut put = new HttpPut(url);
            ObjectMapper mapper = new ObjectMapper();
            StringEntity input = new StringEntity(mapper.writeValueAsString(object) , ContentType.APPLICATION_JSON);
            put.setEntity(input);

            System.out.println("put request : " + url);
            HttpResponse response = client.execute(put);
            System.out.println("response code : " + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String entity = "";
            String line = rd.readLine();
            while (line != null) {
                entity += line ;
                line = rd.readLine();
            }
            return entity;

        }
        catch(IOException e)
        {
            return "";
        }
    }

    public String deleteRequest(String url , String username , String password ) {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials(username, password);
            provider.setCredentials(AuthScope.ANY, credentials);

            HttpClient client = HttpClientBuilder.create()
                    .setDefaultCredentialsProvider(provider)
                    .build();
            HttpDelete delete = new HttpDelete(url);
            ObjectMapper mapper = new ObjectMapper();

            System.out.println("delete request : " + url);
            HttpResponse response = client.execute(delete);
            System.out.println("response code : " + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String entity = "";
            String line = rd.readLine();
            while (line != null) {
                entity += line ;
                line = rd.readLine();
            }
            return entity;

        }
        catch(IOException e)
        {
            return "";
        }
    }

}
