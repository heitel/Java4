package baum;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class SceneGraphDisplay {
	private boolean reverse;
	private int blank;


	public SceneGraphDisplay(boolean reverse) {
		this.reverse = reverse;
		blank = reverse ? -1 : 0;
	}

	public void showSceneGraph(String info, Node node) {
		if (node == null)
			return;

		if (!reverse) {
			print(info, node.getClass().getSimpleName());
		}

		blank++;
		ObservableList<Node> list = null;
		if (node instanceof BorderPane) {
			showBorderPane((BorderPane) node);
		} else if (node instanceof TitledPane) {
			showSceneGraph(null, ((TitledPane) node).getContent());
		} else if (node instanceof ScrollPane) {
			showSceneGraph(null, ((ScrollPane) node).getContent());
		} else if (node instanceof SplitPane) {
			list = ((SplitPane) node).getItems();
		} else if (node instanceof MenuBar) {
			showMenuBar(node);
			blank--;
			return;
		} else if (node instanceof ToolBar) {
			list = ((ToolBar) node).getItems();
		} else if (node instanceof Parent) {
			list = ((Parent) node).getChildrenUnmodifiable();
		}

		if (list != null) {
			for (Node n : list) {
				showSceneGraph(null, n);
			}
		}

		if (reverse) {
			print(node.getClass().getSimpleName(), info);

		}
		blank--;
	}

	private void showBorderPane(BorderPane bp) {
		showSceneGraph("Top:", bp.getTop());
		showSceneGraph("Left:", bp.getLeft());
		showSceneGraph("Right:", bp.getRight());
		showSceneGraph("Bottom:", bp.getBottom());
		showSceneGraph("Center:", bp.getCenter());
	}

	private void showMenuBar(Node node) {
		MenuBar mb = (MenuBar) node;
		ObservableList<Menu> menu = mb.getMenus();
		for (Menu item : menu) {
			showMenu(item);
		}
	}

	private void showMenu(Menu item) {
		showBlank(blank);
		System.out.println("Menu: " + item.getText());
		blank++;
		ObservableList<MenuItem> list = item.getItems();
		for (MenuItem mItem : list) {
			showBlank(blank);
			System.out.println(mItem.getText());
		}
		blank--;
	}

	private void print(String info, String txt) {
		if (info != null) {
			showBlank(blank);
			System.out.println(info);
		}

		if (txt != null) {
			showBlank(blank);
			System.out.println(txt);
		}
	}

	private void showBlank(int anz) {
		for (int i = 0; i < anz; i++) {
			System.out.print("   ");
		}
	}
}
