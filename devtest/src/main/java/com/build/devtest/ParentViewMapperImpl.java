package com.build.devtest;

import java.util.ArrayList;
import java.util.List;

public class ParentViewMapperImpl implements ParentViewMapper{

	@Override
	public List<ParentView> mapRowsToViews(List<ParentRow> parentRows, List<ChildRow> childRows) {
		// TODO Auto-generated method stub
		List<ParentView> parentviewList = new ArrayList<ParentView>();
		for(ParentRow pr: parentRows)
		{
			List<ChildView> childView = new ArrayList<ChildView>();
			String parentId = pr.getParentId();
			
			for(ChildRow cr: childRows)
			{
				if(parentId.equalsIgnoreCase(cr.getParentId()))
				{
					childView.add(new ChildView(cr.getFirstName(), cr.getLastName(), cr.getAge(), cr.getChildId(), null));
				}
			}
			ParentView pv = new ParentView(pr.getFirstName(),pr.getLastName(),pr.getAge(),parentId,childView);
			parentviewList.add(pv);
		}
		//List<ChildRow>
		return parentviewList;
	}

}
