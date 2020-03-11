<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class AwardedController extends Controller
{
    public function index() {
        return Attendee::awarded()
                   ->orderBy('name', 'asc')
                   ->get();
    }
}
