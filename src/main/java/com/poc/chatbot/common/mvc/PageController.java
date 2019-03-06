package com.poc.chatbot.common.mvc;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;


public class PageController {

	@Value("${web.config.default-page-size}")
	private String defaultPageSize;

	/**
	 * �럹�씠吏� �젙蹂� �뀑�똿
	 *
	 * @param params �쁽�옱 �럹�씠吏� 踰덊샇 諛� �럹�씠吏� �궗�씠利�
	 */
	protected void initPageConfig(Map<String, Object> params) {

    	String currentPage = (String)params.get("currentPage");
		String pageSize = (String)params.get("pageSize");

		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}

		if (pageSize == null || pageSize.equals("")) {
			pageSize = defaultPageSize;
		}

		int nPage = Integer.parseInt(currentPage);

		int nSize = Integer.parseInt(pageSize);

		int startRow = (nPage == 1) ? 1 : ((nPage - 1) * nSize) + 1;
		int endRow = startRow + nSize - 1;

		params.put("currentPage", nPage);
		params.put("pageSize", pageSize);
		params.put("startRow", startRow);
		params.put("endRow", endRow);
	}

}
