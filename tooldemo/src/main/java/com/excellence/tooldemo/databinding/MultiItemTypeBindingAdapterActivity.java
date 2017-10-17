package com.excellence.tooldemo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.excellence.basetoolslibrary.databinding.MultiItemTypeBindingAdapter;
import com.excellence.basetoolslibrary.databinding.base.ItemViewDelegate;
import com.excellence.tooldemo.BR;
import com.excellence.tooldemo.R;
import com.excellence.tooldemo.bean.databinding.Flower;
import com.excellence.tooldemo.bean.databinding.Rose;
import com.excellence.tooldemo.bean.databinding.Tulip;

import java.util.ArrayList;
import java.util.List;

public class MultiItemTypeBindingAdapterActivity extends AppCompatActivity
{
	private ActivityMultiItemTypeBindingAdapterBinding mBinding = null;
	private List<Flower> mFlowers = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_multi_item_type_binding_adapter);

		initAdapter();
	}

	private void initAdapter()
	{
		mFlowers = new ArrayList<>();
		mFlowers.add(new Rose("I am Rose", R.drawable.blue));
		mFlowers.add(new Rose("Hello", R.drawable.blue));
		mFlowers.add(new Tulip("e...", R.drawable.purple));
		mFlowers.add(new Rose("King is mine", R.drawable.blue));
		mFlowers.add(new Tulip("Nice", R.drawable.purple));
		MultiItemTypeBindingAdapter<Flower> adapter = new MultiItemTypeBindingAdapter<>(mFlowers);
		adapter.addItemViewDelegate(new RoseViewDelegate());
		adapter.addItemViewDelegate(new TulipViewDelegate());
		mBinding.setAdapter(adapter);
	}

	private class RoseViewDelegate implements ItemViewDelegate<Flower>
	{
		@Override
		public int getItemViewLayoutId()
		{
			return R.layout.item_rose;
		}

		@Override
		public int getItemVariable()
		{
			return BR.rose;
		}

		@Override
		public boolean isForViewType(Flower item, int position)
		{
			return item instanceof Rose;
		}
	}

	private class TulipViewDelegate implements ItemViewDelegate<Flower>
	{
		@Override
		public int getItemViewLayoutId()
		{
			return R.layout.item_tulip;
		}

		@Override
		public int getItemVariable()
		{
			return BR.tulip;
		}

		@Override
		public boolean isForViewType(Flower item, int position)
		{
			return item instanceof Tulip;
		}
	}

}
