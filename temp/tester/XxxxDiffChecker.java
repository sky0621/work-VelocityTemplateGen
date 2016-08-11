package beforeaftercheck;

import static common.XxxxBeanCreator.caseName;

import java.util.HashMap;
import java.util.Map;

import jp.hotpepper.common.mail.bean.content.XxxxBean;

import common.XxxxBeanCreator;

public class XxxxDiffChecker extends FixChecker {

	public XxxxDiffChecker() {
		super("/abc.vm");
	}

	public void process() {

		/*
		 * メール本体VMの分岐ケース（部品への波及も含む）
		 */
		XxxxBean bean = XxxxBeanCreator.caseFull();
		test(caseName, bean, createBeforeParam(bean));

		// #if($!{bean.pcFaxMailHeaderPartsText})
		bean = XxxxBeanCreator.setPcHeaderPartsTextNull();
		test(caseName, bean, createBeforeParam(bean));

		/*
		 * 部品「xxx.vm」の分岐ケース
		 */
		// #if($!{parts.storeComment})
		bean = XxxxBeanCreator.setStoreCommentNull();
		test(caseName, bean, createBeforeParam(bean));

	}

	/*
	 * 修正前のVMに渡すマップの作り方
	 */
	private static Map<String, Object> createBeforeParam(XxxxBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("address", bean.getContentFullBean().getAddressAll());
		return map;
	}

}
