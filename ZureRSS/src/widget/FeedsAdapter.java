package widget;



import java.util.List;
import java.util.Map;
import data.FeedContract;

import android.content.Context;
import android.text.format.DateUtils;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class FeedsAdapter extends SimpleAdapter {
	//video http://francho.org/ HANGOUT #4 min 6:00
	
	//SimpleAdapter-eri pasa behar dizkiogun balioak
	//layout: zein layout-a erabiliko da activity honetan.
	//from: nundik
	//to: nun margotu behar dira datuak.

	private static final String[] FROM = new String[]{FeedContract.TITLE, FeedContract.DATE};
	private static int[] TO = new int[] {android.R.id.text1, android.R.id.text2};
	private Context context;
	
	//ERAIKITZAILEA
	
	public FeedsAdapter(Context context, List<? extends Map<String, ?>> data) {
		//SimpleAdapter bateri pasa behar zaizkion ondorengo balioak
		//contextua, datuak, layout, from eta to.
		super(context, data, android.R.layout.simple_list_item_2, FROM, TO);
		this.context = context;
		
	}

	//tratamos la fecha para mostrarla con un formato adecuado al humano
	@Override
	public void setViewText(TextView v, String text) {
		// TODO Auto-generated method stub
		if(isDateView(v)){
			text = getFormattedDate(text);
		}
		super.setViewText(v, text);
			}
	
	private boolean isDateView(TextView v){
		
		return v.getId() == android.R.id.text2;
		
		}
	
    private String getFormattedDate(String text) {

    Long millis = Long.parseLong(text);
 	return (String)DateUtils.getRelativeTimeSpanString(context, millis);
 	 
 }
	
}
