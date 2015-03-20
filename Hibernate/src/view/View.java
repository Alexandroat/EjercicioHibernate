package view;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class View {

	private JFrame frame;
	private JTextField textPregunta;
	private JComboBox categorias;
	private JTextField respuesta1,respuesta2, respuesta3, respuesta4 ;
	private JCheckBox checkBox1,checkBox2, checkBox3, checkBox4;
	private String categoriaSelect;
	private JButton btnSave;
	private JTextField idQuestion;
	private JTextField modPregunta;
	private JButton btnSearch;
	private JLabel lblRespuesta2;
	private JTextField modResp1,modResp2, modResp3, modResp4 ;
	private JButton btnDelete;
	private JButton btnModify;

	

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 484, 402);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
				JPanel panel = new JPanel();
				tabbedPane.addTab("Add info", null, panel, null);
				panel.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));
				
						JLabel lblPregunta = new JLabel("Pregunta:");
						panel.add(lblPregunta, "6, 2");
						
								JLabel lblTexto = new JLabel("Texto");
								panel.add(lblTexto, "6, 6");
								
										JLabel lblTextoPregunta = new JLabel("Categor\u00EDa");
										panel.add(lblTextoPregunta, "12, 6");
										
												textPregunta = new JTextField();
												panel.add(textPregunta, "6, 8, fill, default");
												textPregunta.setColumns(10);
												
														categorias = new JComboBox();
														categorias.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
																categoriaSelect = categorias.getSelectedItem().toString();

															}
														});
														categorias.setModel(new DefaultComboBoxModel(new String[] { "-",
																"Cine", "Televisi\u00F3n", "Arte", "Deporte", "Ciencia",
																"M\u00FAsica", "Tecnolog\u00EDa" }));
														panel.add(categorias, "12, 8, fill, default");
														
																JLabel lblRespuestas = new JLabel("Respuestas:");
																panel.add(lblRespuestas, "6, 12");
																
																		respuesta1 = new JTextField();
																		panel.add(respuesta1, "6, 16, fill, default");
																		respuesta1.setColumns(10);
																		
																				checkBox1 = new JCheckBox("");
																				checkBox1.setToolTipText("Seleccionar si la pregunta es verdadera");
																				panel.add(checkBox1, "8, 16");
																				
																						respuesta3 = new JTextField();
																						panel.add(respuesta3, "12, 16, fill, default");
																						respuesta3.setColumns(10);
																						
																								checkBox3 = new JCheckBox("");
																								checkBox3.setToolTipText("Seleccionar si la pregunta es verdadera");
																								panel.add(checkBox3, "14, 16");
																								
																										respuesta2 = new JTextField();
																										panel.add(respuesta2, "6, 20, fill, default");
																										respuesta2.setColumns(10);
																										
																												checkBox2 = new JCheckBox("");
																												checkBox2.setToolTipText("Seleccionar si la pregunta es verdadera");
																												panel.add(checkBox2, "8, 20");
																												
																														respuesta4 = new JTextField();
																														panel.add(respuesta4, "12, 20, fill, default");
																														respuesta4.setColumns(10);
																														
																																checkBox4 = new JCheckBox("");
																																checkBox4.setToolTipText("Seleccionar si la pregunta es verdadera");
																																panel.add(checkBox4, "14, 20");
																																
																																		btnSave = new JButton("Save");
																																		
																																		panel.add(btnSave, "12, 24");
																																		
																																		JPanel panel_1 = new JPanel();
																																		tabbedPane.addTab("Get & Modify", null, panel_1, null);
																																		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
																																				FormFactory.RELATED_GAP_COLSPEC,
																																				FormFactory.DEFAULT_COLSPEC,
																																				FormFactory.RELATED_GAP_COLSPEC,
																																				FormFactory.DEFAULT_COLSPEC,
																																				FormFactory.RELATED_GAP_COLSPEC,
																																				FormFactory.DEFAULT_COLSPEC,
																																				FormFactory.RELATED_GAP_COLSPEC,
																																				ColumnSpec.decode("default:grow"),
																																				FormFactory.RELATED_GAP_COLSPEC,
																																				ColumnSpec.decode("max(49dlu;default):grow"),
																																				FormFactory.RELATED_GAP_COLSPEC,
																																				ColumnSpec.decode("default:grow"),},
																																			new RowSpec[] {
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,
																																				FormFactory.RELATED_GAP_ROWSPEC,
																																				FormFactory.DEFAULT_ROWSPEC,}));
																																		
																																		JLabel lblIntroduzcaElId = new JLabel("Introduce el ID de la pregunta :");
																																		panel_1.add(lblIntroduzcaElId, "6, 4");
																																		
																																		idQuestion = new JTextField();
																																		panel_1.add(idQuestion, "8, 4, center, default");
																																		idQuestion.setColumns(10);
																																		
																																		btnSearch = new JButton("Buscar");
																																		panel_1.add(btnSearch, "10, 4");
																																		
																																		JLabel lblpreguntaMod = new JLabel("Pregunta: ");
																																		panel_1.add(lblpreguntaMod, "6, 8, center, default");
																																		
																																		modPregunta = new JTextField();
																																		panel_1.add(modPregunta, "8, 8, 3, 1, fill, default");
																																		modPregunta.setColumns(10);
																																		
																																		JLabel lblRespuesta = new JLabel("Respuesta 1");
																																		panel_1.add(lblRespuesta, "6, 12, center, default");
																																		
																																		modResp1 = new JTextField();
																																		panel_1.add(modResp1, "8, 12, 3, 1, fill, default");
																																		modResp1.setColumns(10);
																																		
																																		lblRespuesta2 = new JLabel("Respuesta 2");
																																		panel_1.add(lblRespuesta2, "6, 14, center, default");
																																		
																																		modResp2 = new JTextField();
																																		panel_1.add(modResp2, "8, 14, 3, 1, fill, default");
																																		modResp2.setColumns(10);
																																		
																																		JLabel lblRespuesta3 = new JLabel("Respuesta 3");
																																		panel_1.add(lblRespuesta3, "6, 16, center, default");
																																		
																																		modResp3 = new JTextField();
																																		panel_1.add(modResp3, "8, 16, 3, 1, fill, default");
																																		modResp3.setColumns(10);
																																		
																																		JLabel lblRespuesta4 = new JLabel("Respuesta 4");
																																		panel_1.add(lblRespuesta4, "6, 18, center, default");
																																		
																																		modResp4 = new JTextField();
																																		panel_1.add(modResp4, "8, 18, 3, 1, fill, default");
																																		modResp4.setColumns(10);
																																		
																																		btnDelete = new JButton("Eliminar");
																																		btnDelete.addActionListener(new ActionListener() {
																																			public void actionPerformed(ActionEvent arg0) {
																																				
																																			}
																																		});
																																		panel_1.add(btnDelete, "8, 22");
																																		
																																		btnModify = new JButton("Cambiar");
																																		panel_1.add(btnModify, "10, 22");
	}

	public JTextField getTextPregunta() {
		return textPregunta;
	}

	public JComboBox getCategorias() {
		return categorias;
	}

	public JTextField getRespuesta1() {
		return respuesta1;
	}

	public JCheckBox getCheckBox1() {
		return checkBox1;
	}

	public JTextField getRespuesta2() {
		return respuesta2;
	}

	public JTextField getRespuesta3() {
		return respuesta3;
	}

	public JTextField getRespuesta4() {
		return respuesta4;
	}

	public JCheckBox getCheckBox2() {
		return checkBox2;
	}

	public JCheckBox getCheckBox3() {
		return checkBox3;
	}

	public JCheckBox getCheckBox4() {
		return checkBox4;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String getCategoriaSelect() {
		return categoriaSelect;
	}
	public JButton getSaveBtn() {
		return btnSave;
	}

	public JTextField getIdQuestion() {
		return idQuestion;
	}

	public JTextField getModPregunta() {
		return modPregunta;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JLabel getLblRespuesta2() {
		return lblRespuesta2;
	}

	public JTextField getModResp1() {
		return modResp1;
	}

	public JTextField getModResp2() {
		return modResp2;
	}

	public JTextField getModResp3() {
		return modResp3;
	}

	public JTextField getModResp4() {
		return modResp4;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnModify() {
		return btnModify;
	}
	
}
