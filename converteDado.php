<?php
/**Converte dado da requisição para 'date' para inserções no formato 'yyyy-mm-dd'*/
date('Y-m-d',strtotime(str_replace('/','-',$_REQUEST['data_para_converter'])));
date('Y-m-d',strtotime(str_replace('/','-',$this->input->post_get('data_para_converter'))));
