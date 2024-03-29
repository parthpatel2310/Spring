<?php
include('config.php');
$database = new Database();
$result = $database->runQuery("Select USER_NAME ,EMAIL , CONTACT  
								from users");
$header = $database->runQuery("SELECT UCASE(`COLUMN_NAME`) 
FROM `INFORMATION_SCHEMA`.`COLUMNS` 
WHERE `TABLE_SCHEMA`='sparkleboutique' 
AND `TABLE_NAME`='users'
and `COLUMN_NAME` in ('USER_NAME','EMAIL','CONTACT')");
require('fpdf/fpdf.php');
$pdf = new FPDF();
$pdf->AddPage();
$pdf->SetFont('Arial','B',16);

// Set header
 $pdf->Image('add1.jpg',7,1,25);
    // Move to the right
    $pdf->Cell(80);
    // Title
    $pdf->Cell(80,10,'User List',1,0,'C');
    // Line break
    $pdf->Ln(20);

foreach($header as $heading) {
	foreach($heading as $column_heading)
		$pdf->Cell(65,12,$column_heading,1);
}
foreach($result as $row) {
	$pdf->Ln();
	foreach($row as $column)
		$pdf->Cell(65,12,$column,1);
}
$pdf->Output();

// Set footer
   $pdf->SetY(-15);
    // Arial italic 8
    $pdf->SetFont('Arial','I',8);
    // Page number
    $pdf->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
?>