package com.itour.base.util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
public class ESUtil {

    //  private static final String CLUSTER_NAME = "cluster_name";
    public static final String CLUSTER_NAME = "elasticsearch";//ʵ������
    private static final String IP = "192.168.10.157";
    //private static final String IP = "192.168.0.29";
    private static final int PORT = 9300;  //�˿�
    //1.���ü�Ⱥ���ƣ�Ĭ����elasticsearch��������client.transport.sniffΪtrue��ʹ�ͻ�����̽������Ⱥ״̬���Ѽ�Ⱥ�е���������IP���뵽�ͻ�����
    /*
    //��ES1.6��Ч
    private static Settings settings = ImmutableSettings
            .settingsBuilder()
            .put("cluster.name",CLUSTER_NAME)
            .put("client.transport.sniff", true)
            .build();
    */
    //��ES2.0��Ч
    private static Settings settings = Settings.settingsBuilder().put("cluster.name",CLUSTER_NAME).put("client.transport.sniff", true).build();
    //����˽�ж���
    private static TransportClient client;
    //������ƴ���������TransportClient����  ES1.6�汾
//    static {
//        try {
//            Class<?> clazz = Class.forName(TransportClient.class.getName());
//            Constructor<?> constructor = clazz.getDeclaredConstructor(Settings.class);
//            constructor.setAccessible(true);
//            client = (TransportClient) constructor.newInstance(settings);
//            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    //ES2.0�汾
    static {
        try {
            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    //ȡ��ʵ��
    public static synchronized TransportClient getTransportClient(){
        return client;
    }

    //Ϊ��Ⱥ����µĽڵ�
    public static synchronized void addNode(String name){
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    //ɾ����Ⱥ�е�ĳ���ڵ�
    public static synchronized void removeNode(String name){
        try {
            client.removeTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public static String generateJson() {
        String json = "";
        try {
            XContentBuilder contentBuilder = XContentFactory.jsonBuilder()
                    .startObject();
            contentBuilder.field("id",  "12");
            contentBuilder.field("name","song" );
            contentBuilder.field("age", "23");
            json = contentBuilder.endObject().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static void main(String args[]){
        String index="logstash-2016.05.16";
        String type="logs";
        for(int i=0;i<1000;i++){
            ESUtil.getTransportClient().prepareIndex(index, type).setSource(
                    generateJson()).execute().actionGet();
        }
        //�ɹ�
//        SearchResponse response=ElkTest.getTransportClient().prepareSearch(index)//����Ҫ��ѯ������(index)
//        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//        .setTypes(type)//����type, ����ڽ���������ʱ��ͬʱ������, ���߿���ʹ��head���߲鿴
//        .setQuery(QueryBuilders.matchQuery("message", "Accept")) //������"message"��Ҫ��ѯ��field,"Accept"��Ҫ��ѯ������
//        .setFrom(0)
//        .setSize(10)
//        .setExplain(true)
//        .execute()
//        .actionGet();

//        for(SearchHit hit:response.getHits()){
//            System.out.println(hit.getSourceAsString());
//        }
    }
}
