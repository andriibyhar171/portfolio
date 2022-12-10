using PdfSharp.Drawing;
using PdfSharp.Pdf;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Resume
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Open1(object sender, RoutedEventArgs e)
        {
            Resume1 resume1 = new Resume1();
            resume1.Show();
            this.Close();

        }
        private void Open2(object sender, RoutedEventArgs e)
        {
            Resume2 resume2 = new Resume2();
            resume2.Show();
            this.Close();
        }

        private void Open3(object sender, RoutedEventArgs e)
        {
            Resume3 resume3 = new Resume3();
            resume3.Show();
            this.Close();
        }

        private void Cls(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

       
    }
}