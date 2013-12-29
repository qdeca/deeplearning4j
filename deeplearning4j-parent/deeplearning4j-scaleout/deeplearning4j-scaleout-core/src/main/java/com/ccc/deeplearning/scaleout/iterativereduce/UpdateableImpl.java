package com.ccc.deeplearning.scaleout.iterativereduce;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

import com.ccc.deeplearning.nn.matrix.jblas.BaseMultiLayerNetwork;
import com.ccc.deeplearning.scaleout.iterativereduce.Updateable;

public class UpdateableImpl implements Updateable<BaseMultiLayerNetwork> {

	
	private static final long serialVersionUID = 6547025785641217642L;
	private BaseMultiLayerNetwork wrapped;
	private Class<? extends BaseMultiLayerNetwork> clazz;
	

	public UpdateableImpl(BaseMultiLayerNetwork matrix) {
		wrapped = matrix;
		if(clazz == null)
			clazz = matrix.getClass();
	}
	
	@Override
	public ByteBuffer toBytes() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		return ByteBuffer.wrap(os.toByteArray());
		
	}

	@Override
	public void fromBytes(ByteBuffer b) {
		wrapped = new BaseMultiLayerNetwork.Builder<>()
				.withClazz(clazz).buildEmpty();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(b.array())));
		wrapped.load(dis);
	}

	@Override
	public void fromString(String s) {
		
	}

	@Override
	public BaseMultiLayerNetwork get() {
		return wrapped;
	}

	@Override
	public void set(BaseMultiLayerNetwork type) {
		this.wrapped = type;
	}




}
