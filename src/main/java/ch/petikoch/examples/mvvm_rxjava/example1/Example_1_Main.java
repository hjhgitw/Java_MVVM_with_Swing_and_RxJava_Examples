/**
 * Copyright 2015 Peti Koch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.petikoch.examples.mvvm_rxjava.example1;

import ch.petikoch.examples.mvvm_rxjava.utils.SwingUtilities2;
import ch.petikoch.examples.mvvm_rxjava.utils.SysOutUtils;
import ch.petikoch.examples.mvvm_rxjava.utils.UncaughtExceptionHandlerInitializer;

import javax.swing.*;
import java.lang.management.ManagementFactory;

class Example_1_Main {

    public static void main(String[] args) {
        SysOutUtils.sysout(ManagementFactory.getRuntimeMXBean().getName());
        UncaughtExceptionHandlerInitializer.initUncaughtExceptionHandler();

        Example_1_Model model = new Example_1_Model();
        Example_1_ViewModel viewModel = new Example_1_ViewModel();
        viewModel.connectTo(model);

        SwingUtilities2.invokeLater(() -> {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Example_1_View view = new Example_1_View();
            view.bind(viewModel);
            view.setVisible(true);
        });
    }
}
