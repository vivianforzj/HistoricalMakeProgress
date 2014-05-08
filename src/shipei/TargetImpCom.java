package shipei;

public class TargetImpCom implements TargetIFC{
	private SourceIFC source;
	public TargetImpCom(SourceIFC source){
		this.source = source;
	}
	
	public int add(int a, int b){return source.add(a, b);}
	public int addOne(int a){return source.add(a, 1);}
}
