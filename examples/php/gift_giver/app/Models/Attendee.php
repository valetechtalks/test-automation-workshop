<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Attendee extends Model
{
    protected $fillable = [
        'name', 'vendor_member_id', 'languages', 'awarded',
    ];

    protected $attributes = [
        'awarded' => false,
    ];
}
