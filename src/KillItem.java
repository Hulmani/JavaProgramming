
public class KillItem {

		 int val;
		
		KillItem next;
		
		public KillItem(int val)
		{
			this.val=val;	
		}
		
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public KillItem getNext() {
			return next;
		}
		public void setNext(KillItem next) {
			this.next = next;
		}
		public KillItem delete (KillItem nextItem)
		{
			KillItem next=nextItem.getNext();
			
			int val=next.getVal();
			System.out.println(nextItem.val+" killed "+val );
			nextItem.setNext(next.getNext());   
			
			return next.getNext();
		}
		
		
}
