package us.gfzj.hadooprelated.hbase.endpoint;

import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.coprocessor.Batch;
import org.apache.hadoop.hbase.ipc.BlockingRpcCallback;
import org.apache.hadoop.hbase.ipc.ServerRpcController;

import com.google.protobuf.ServiceException;

import us.gfzj.hadooprelated.hbase.endpoint.NumCountProtos.NumCountRequest;
import us.gfzj.hadooprelated.hbase.endpoint.NumCountProtos.NumCountResponse;
import us.gfzj.hadooprelated.hbase.endpoint.NumCountProtos.NumCountService;
import us.gfzj.hadooprelated.hbase.util.BasicConnection;

public class NumCountClient {
	
	public static void main(String[] args) throws ServiceException, Throwable {
		HTableInterface table = null;
		//initialize your table 
		//table = BasicConnection.getTable("student_info");
		Batch.Call<NumCountService, NumCountResponse> callable = 
				new Batch.Call<NumCountService, NumCountResponse>() {
			ServerRpcController controller = new ServerRpcController();
			BlockingRpcCallback<NumCountResponse> rpcCallback = 
					new BlockingRpcCallback<NumCountResponse>();

			@Override
			public NumCountResponse call(NumCountService service)
					throws IOException {
				NumCountRequest.Builder builder = NumCountRequest.newBuilder();
				builder.setSex(0); //0 表示男性 1表示女性
				service.getNumCount(controller, builder.build(), rpcCallback);
				return rpcCallback.get();
			}
		};
		
		Map<byte[], NumCountResponse> result = table.coprocessorService(NumCountService.class, 
				null, null, callable);
		for (NumCountResponse response : result.values())
			System.out.println(response.getCount());
		
		table.close();
	}
}
