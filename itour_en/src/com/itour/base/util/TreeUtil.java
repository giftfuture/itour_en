package com.itour.base.util;

import java.util.ArrayList;
import java.util.List;

import com.itour.base.entity.TreeNode;
import com.itour.entity.SysMenu;
import com.itour.entity.SysMenuBtn;

public class TreeUtil {
	private final static String MENU_ID = "menu_";
	
	private final static String BTN_ID = "btn_";
	
	
	List<SysMenu> rootMenus;
	List<SysMenu> childMenus;
	List<SysMenuBtn> childBtns;
	
	public TreeUtil(List<SysMenu> rootMenus,List<SysMenu> childMenus){
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
	}  
	
	public TreeUtil(List<SysMenu> rootMenus,List<SysMenu> childMenus,List<SysMenuBtn> childBtns){
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
		this.childBtns = childBtns;
	}  
	
	public List<TreeNode> getTreeNode(){
		return getRootNodes();
	}
	
	public static List<String> nodeUrls(TreeUtil treeutil){
		List<String> urls = new ArrayList<String>();
		
		for(SysMenu node:treeutil.rootMenus){
			urls.add(node.getUrl());
		}
		for(SysMenu node:treeutil.childMenus){
			urls.add(node.getUrl());
		}
		for(SysMenuBtn node:treeutil.childBtns){
			urls.add(node.getActionUrls());
		}
		return urls;
	}
	
	/**
	 * 
	 * @param menu
	 * @return
	 */
	private TreeNode menuToNode(SysMenu menu){
		if(menu == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(MENU_ID+menu.getId());
		node.setDataId(menu.getId());
		node.setText(menu.getName());
		node.setUrl(menu.getUrl());
		node.setParentId(menu.getParentId());
		node.getAttributes().put("type", "0");//0为菜单
		node.getAttributes().put("id", menu.getId());
		return node;
	}
	
	
	/**
	 * 
	 * @param menu
	 * @return
	 */
	private TreeNode btnToNode(SysMenuBtn btn){
		if(btn == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(BTN_ID+btn.getId());
		node.setDataId(btn.getId());
		node.setText(btn.getBtnName());
		node.setParentId(btn.getMenuid());
		node.getAttributes().put("type", "1");//1为按钮
		node.getAttributes().put("id", btn.getId());
		return node;
	}
	
	/**
	 * 
	 * @return
	 */
	private List<TreeNode> getRootNodes(){
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		for(SysMenu menu : rootMenus){
			TreeNode node = menuToNode(menu);
			if(node != null){
				addChildNodes(node);
				rootNodes.add(node);
			}
		}
		return rootNodes;
	}
	
	/**
	 * 
	 * @param menu
	 * @return
	 */
	private void addChildNodes(TreeNode rootNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		for(SysMenu menu : childMenus){
			if(rootNode.getDataId().equals(menu.getParentId())){
				TreeNode node = menuToNode(menu);
				if(childBtns != null && !childBtns.isEmpty()){
					addChlidBtn(node);
				}
				childNodes.add(node);
			}
		}
		rootNode.setChildren(childNodes);
	}
	
	
	/**
	 * 设置菜单button
	 * @param menu
	 * @return
	 */
	private void addChlidBtn(TreeNode treeNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>(); 
		for(SysMenuBtn btn : childBtns){
			if(treeNode.getDataId().equals(btn.getMenuid())){
				TreeNode node = btnToNode(btn);
				childNodes.add(node);
			}
		}
		treeNode.setChildren(childNodes);
	}
	
	
	
}
