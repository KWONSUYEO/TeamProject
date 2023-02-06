package com.soldesk.jan05.review;

import java.util.List;

public interface ReviewMapper {
	public abstract int deleteMsg(Review rm);

	public abstract int deleteReply(ReviewReply rr);

	public abstract int getAllMsgCount();

	public abstract List<Review> getMsg(ReviewSelector rSel);

	public abstract List<ReviewReply> getReply(Review rm);

	public abstract int getSearchMsgCount(ReviewSelector rSel);

	public abstract int writeMsg(Review rm);

	public abstract int writeReply(ReviewReply rr);

	public abstract int updateMsg(Review rm);
}
