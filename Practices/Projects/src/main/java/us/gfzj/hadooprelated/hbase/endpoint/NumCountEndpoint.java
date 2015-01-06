package us.gfzj.hadooprelated.hbase.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.Coprocessor;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.coprocessor.CoprocessorException;
import org.apache.hadoop.hbase.coprocessor.CoprocessorService;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.regionserver.InternalScanner;
import org.apache.hadoop.hbase.util.Bytes;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.google.protobuf.Service;

import us.gfzj.hadooprelated.hbase.endpoint.NumCountProtos.NumCountRequest;
import us.gfzj.hadooprelated.hbase.endpoint.NumCountProtos.NumCountResponse;
import us.gfzj.hadooprelated.hbase.endpoint.NumCountProtos.NumCountService;

public class NumCountEndpoint extends NumCountService implements
		CoprocessorService, Coprocessor {

	private RegionCoprocessorEnvironment env;

	@Override
	public void start(CoprocessorEnvironment arg0) throws IOException {
		if (env instanceof RegionCoprocessorEnvironment) {
			this.env = (RegionCoprocessorEnvironment) env;
		} else {
			throw new CoprocessorException("Must be loaded on a table region!");
		}
	}

	@Override
	public void stop(CoprocessorEnvironment arg0) throws IOException {
		// nothing to do
	}

	@Override
	public Service getService() {
		return this;
	}

	@Override
	public void getNumCount(RpcController controller, NumCountRequest request,
			RpcCallback<NumCountResponse> done) {
		NumCountResponse response = null;
		int sex = request.getSex();
		Scan scan = new Scan();
		scan.setFilter(new SingleColumnValueFilter(Bytes.toBytes("cf"), 
				Bytes.toBytes("sex"), CompareOp.EQUAL, Bytes.toBytes(sex)));
		int count = 0;
		try (InternalScanner scanner = env.getRegion().getScanner(scan)) {
			List<Cell> kvResults = new ArrayList<Cell>();
			while (scanner.next(kvResults)) {
				count++;
				kvResults.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response = NumCountResponse.newBuilder().setCount(count).build();
		done.run(response);
	}

}
